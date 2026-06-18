package com.library.management.service.Impl;

import com.library.management.DTO.ResourceRequest;
import com.library.management.DTO.ResourceResponse;
import com.library.management.entity.Author;
import com.library.management.entity.Category;
import com.library.management.entity.Publisher;
import com.library.management.entity.Resource;
import com.library.management.Exception.ResourceNotFoundException;
import com.library.management.repo.*;
import com.library.management.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceTypeRepository resourceTypeRepository;
    private final LanguageRepository languageRepository;
    private final RoomRepository roomRepository;
    private final RackRepository rackRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;

    public ResourceServiceImpl(
            ResourceRepository resourceRepository,
            ResourceTypeRepository resourceTypeRepository,
            LanguageRepository languageRepository,
            RoomRepository roomRepository, RackRepository rackRepository,
            AuthorRepository authorRepository,PublisherRepository publisherRepository,
            CategoryRepository categoryRepository) {

        this.resourceRepository = resourceRepository;
        this.resourceTypeRepository = resourceTypeRepository;
        this.languageRepository = languageRepository;
        this.roomRepository = roomRepository;
        this.rackRepository = rackRepository;
        this.authorRepository=authorRepository;
        this.publisherRepository=publisherRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public ResourceResponse save(ResourceRequest request) {

        if (resourceRepository
                .findByIsbnBarcode(request.getIsbnBarcode())
                .isPresent()) {

            throw new RuntimeException(
                    "ISBN already exists");
        }

        Resource resource = new Resource();

        mapResource(resource, request);

        Resource saved =
                resourceRepository.save(resource);

        return mapToDTO(saved);
    }

    @Override
    public List<ResourceResponse> getAll() {

        return resourceRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public ResourceResponse getById(Long id) {

        Resource resource =
                resourceRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Resource not found"));

        return mapToDTO(resource);
    }

    @Override
    public ResourceResponse update(
            Long id,
            ResourceRequest request) {

        Resource resource =
                resourceRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Resource not found"));

        if (resourceRepository
                .findByIsbnBarcode(request.getIsbnBarcode())
                .filter(r -> !r.getId().equals(id))
                .isPresent()) {

            throw new RuntimeException(
                    "ISBN already exists");
        }

        mapResource(resource, request);

        Resource updated =
                resourceRepository.save(resource);

        return mapToDTO(updated);
    }

    @Override
    public String delete(Long id) {

        if (!resourceRepository.existsById(id)) {

            throw new ResourceNotFoundException(
                    "Resource not found");
        }

        resourceRepository.deleteById(id);

        return "Resource deleted successfully";
    }

    private void mapResource(
            Resource resource,
            ResourceRequest request) {

        resource.setIsbnBarcode(
                request.getIsbnBarcode());

        resource.setTitle(
                request.getTitle());

        resource.setEdition(
                request.getEdition());

        List<Author> authors =
                authorRepository.findAllById(
                        request.getAuthorIds());

        List<Category> categories =
                categoryRepository.findAllById(
                        request.getCategoryIds());

        Publisher publisher =
                publisherRepository.findById(
                                request.getPublisherId())
                        .orElseThrow(() ->
                                new RuntimeException("Publisher not found"));

        resource.setAuthors(authors);
        resource.setCategories(categories);
        resource.setPublisher(publisher);

        resource.setQuantity(
                request.getQuantity());

        resource.setResourceType(
                resourceTypeRepository
                        .findById(
                                request.getResourceTypeId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Resource Type not found")));

        resource.setLanguage(
                languageRepository
                        .findById(
                                request.getLanguageId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Language not found")));

        resource.setRoom(
                roomRepository
                        .findById(
                                request.getRoomId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Room not found")));

        resource.setRack(
                rackRepository
                        .findById(
                                request.getRackId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Rack not found")));
    }

    private ResourceResponse mapToDTO(
            Resource resource) {

        ResourceResponse response =
                new ResourceResponse();

        response.setId(resource.getId());

        response.setIsbnBarcode(
                resource.getIsbnBarcode());

        response.setTitle(
                resource.getTitle());

        response.setEdition(
                resource.getEdition());

        response.setAuthors(
                resource.getAuthors()
                        .stream()
                        .map(Author::getName)
                        .toList()
        );

        response.setCategories(
                resource.getCategories()
                        .stream()
                        .map(Category::getName)
                        .toList()
        );

        response.setPublisher(
                resource.getPublisher().getName()
        );
        response.setQuantity(
                resource.getQuantity());

        response.setStatus(
                resource.getStatus().name());

        response.setCreatedAt(
                resource.getCreatedAt());

        if (resource.getResourceType() != null) {

            response.setResourceTypeName(
                    resource.getResourceType()
                            .getName());
        }

        if (resource.getLanguage() != null) {

            response.setLanguageName(
                    resource.getLanguage()
                            .getName());
        }

        if (resource.getRoom() != null) {

            response.setRoomName(
                    resource.getRoom()
                            .getName());
        }

        if (resource.getRack() != null) {

            response.setRackName(
                    resource.getRack()
                            .getName());
        }

        return response;
    }
}