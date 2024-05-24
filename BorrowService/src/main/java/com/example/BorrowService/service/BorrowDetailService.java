package com.example.BorrowService.service;

import com.example.BorrowService.models.BorrowDetail;
import com.example.BorrowService.repositories.BorrowDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowDetailService {
    @Autowired
    private BorrowDetailRepository borrowDetailRepository;

    public BorrowDetail saveBorrowDetail(BorrowDetail borrowDetail) {
        return borrowDetailRepository.save(borrowDetail);
    }

    public BorrowDetail findBorrowDetail(Long id) {
        return borrowDetailRepository.findById(id).orElse(null);
    }

    // Thêm các phương thức khác theo nhu cầu
}
