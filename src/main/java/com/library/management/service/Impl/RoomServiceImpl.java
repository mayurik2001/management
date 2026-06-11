package com.library.management.service.Impl;

import com.library.management.entity.Room;
import com.library.management.repo.RoomRepository;
import com.library.management.service.RoomService;
import org.springframework.stereotype.Service;


@Service
public class RoomServiceImpl extends BaseLookupServiceImpl<Room>
            implements RoomService {
      public RoomServiceImpl(RoomRepository repository){
          super(repository);
      }
}
