package com.example.BorrowService.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BorrowService.dto.BookRequest;
import com.example.BorrowService.dto.BorrowRequest;
import com.example.BorrowService.models.Borrow;
import com.example.BorrowService.models.BorrowDetail;
import com.example.BorrowService.repositories.BorrowRepository;

@Service
public class BorrowService {

	@Autowired
    private BorrowRepository borrowRepository;

    public void borrowBooks(BorrowRequest borrowRequest) {
        Borrow borrow = new Borrow();
        borrow.setUserId(borrowRequest.getUserId());
        List<BorrowDetail> borrowDetailsList = new ArrayList<>();
        for (BookRequest bookRequest : borrowRequest.getBooks()) {
            BorrowDetail borrowDetail = new BorrowDetail();
            borrowDetail.setQuantity(bookRequest.getQuantity());
            borrowDetailsList.add(borrowDetail);
        }

        borrow.setBooks(borrowDetailsList);
        borrow.setBorrowedDate(LocalDate.now());
        borrow.setReturned(false);
        borrowRepository.save(borrow);
    }
}
