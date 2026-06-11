package com.library.management.service.Impl;

import com.library.management.DTO.BookAssignRequest;
import com.library.management.DTO.BookAssignResponse;
import com.library.management.entity.BookAssign;
import com.library.management.entity.Member;
import com.library.management.entity.Resource;
import com.library.management.enums.BookAssignStatus;
import com.library.management.repo.BookAssignRepository;
import com.library.management.repo.MemberRepository;
import com.library.management.repo.ResourceRepository;
import com.library.management.service.BookAssignService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookAssignServiceImpl implements BookAssignService {

    private final BookAssignRepository bookAssignRepository;
    private final MemberRepository memberRepository;
    private final ResourceRepository resourceRepository;

    public BookAssignServiceImpl(BookAssignRepository bookAssignRepository,MemberRepository memberRepository,
                                 ResourceRepository resourceRepository ){

        this.bookAssignRepository=bookAssignRepository;
        this.memberRepository=memberRepository;
        this.resourceRepository=resourceRepository;
    }

    @Override
    public BookAssignResponse assignBook(BookAssignRequest request){
        Member member=memberRepository.findById(request.getMemberId())
                .orElseThrow(()->
                        new RuntimeException("Member not found"));

        Resource resource=resourceRepository.findById(request.getResourceId())
                .orElseThrow(()->
                       new RuntimeException("Resource not found"));

        if(resource.getQuantity()<=0){
            throw new RuntimeException("Book is not available");
        }
        boolean alreadyAssigned =
                bookAssignRepository.existsByMemberIdAndResourceIdAndStatus(
                        request.getMemberId(),
                        request.getResourceId(),
                        BookAssignStatus.ACTIVE);

        if (alreadyAssigned) {

            throw new RuntimeException(
                    "Book already assigned to member");
        }
        BookAssign bookAssign=new BookAssign();
        bookAssign.setMember(member);
        bookAssign.setResource(resource);
        bookAssign.setAssignDate(request.getAssignDate());
        bookAssign.setReturnDate(request.getReturnDate());

        resource.setQuantity(resource.getQuantity()-1);
        resourceRepository.save(resource);
        BookAssign saved=bookAssignRepository.save(bookAssign);
        return mapToDTO(saved);
    }

    @Override
    public List<BookAssignResponse>getAll() {
        return bookAssignRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public BookAssignResponse getById(Long id) {
        BookAssign bookassign =
                bookAssignRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Assignment not found"));
        return mapToDTO(bookassign);
    }
    @Override
    public BookAssignResponse update(
            Long id,
            BookAssignRequest request) {

        BookAssign assignment =
                bookAssignRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Assignment not found"));

        Member member = memberRepository.findById(
                        request.getMemberId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Member not found"));

        Resource resource = resourceRepository.findById(
                        request.getResourceId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Resource not found"));

        assignment.setMember(member);
        assignment.setResource(resource);
        assignment.setAssignDate(
                request.getAssignDate());
        assignment.setReturnDate(
                request.getReturnDate());

        BookAssign updated =
                bookAssignRepository.save(assignment);

        return mapToDTO(updated);
    }

    @Override
    public String delete(Long id) {

        if (!bookAssignRepository.existsById(id)) {
            throw new RuntimeException(
                    "Assignment not found");
        }

        bookAssignRepository.deleteById(id);

        return "Assignment deleted successfully";
    }


    @Override
    public BookAssignResponse returnBook(Long id) {

        BookAssign assignment =
                bookAssignRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Assignment not found"));

        if (assignment.getStatus()
                == BookAssignStatus.RETURNED) {

            throw new RuntimeException(
                    "Book already returned");
        }

        assignment.setStatus(BookAssignStatus.RETURNED);

        assignment.setReturnDate(LocalDate.now());

        Resource resource = assignment.getResource();

        resource.setQuantity(resource.getQuantity() + 1);

        resourceRepository.save(resource);

        BookAssign updated =
                bookAssignRepository.save(assignment);

        return mapToDTO(updated);
    }

    private BookAssignResponse mapToDTO(BookAssign assignment) {

        BookAssignResponse response=new BookAssignResponse();

        response.setId(assignment.getId());

        response.setMemberId(assignment.getMember().getId());

        response.setMemberName(assignment.getMember().getName());

        response.setResourceId(assignment.getResource().getId());

        response.setResourceTitle(assignment.getResource().getTitle());

        response.setAssignDate(assignment.getAssignDate());

        response.setReturnDate(assignment.getReturnDate());

        response.setStatus(assignment.getStatus());

        response.setAssignedAt(assignment.getAssignedAt());

        return response;
    }

}



