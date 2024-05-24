//package com.example.BorrowService.service;
//
//import java.net.URI;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.example.BorrowService.dto.BookRequest;
//import com.example.BorrowService.dto.BorrowRequest;
//import com.example.BorrowService.dto.InventoryResponse;
//import com.example.BorrowService.models.Borrow;
//import com.example.BorrowService.models.BorrowDetail;
//import com.example.BorrowService.repositories.BorrowRepository;
//
//import jakarta.persistence.EntityManager;
//
//
//@Service
//public class BorrowService {
//
//	 private final WebClient webClient; // Declaring WebClient as final
//	 private final BorrowRepository borrowRepository;
//	 private final EntityManager entityManager; // Inject EntityManager
//
//	 public BorrowService(WebClient.Builder webClientBuilder, BorrowRepository borrowRepository, EntityManager entityManager) {
//	     this.webClient = webClientBuilder.baseUrl("http://localhost:9020/api").build();
//	     this.borrowRepository = borrowRepository;
//	     this.entityManager = entityManager; // Inject EntityManager
//	 }
//
//	@Transactional
//    public String borrowBooks(BorrowRequest borrowRequest) {
//        Borrow borrow = new Borrow();
//        borrow.setUserId(borrowRequest.getUserId());
//        List<BorrowDetail> borrowDetailsList = new ArrayList<>();
//        for (BookRequest bookRequest : borrowRequest.getBooks()) {
//            BorrowDetail borrowDetail = new BorrowDetail();
//            borrowDetail.setId(bookRequest.getBookId());
//            borrowDetail.setQuantity(bookRequest.getQuantity());
//            borrowDetailsList.add(borrowDetail);
//        }
//
//        borrow.setBooks(borrowDetailsList);
//        borrow.setBorrowedDate(LocalDate.now());
//        borrow.setReturned(false);
//
//
//        List<Long> bookIds = borrow.getBooks().stream()
//        		.map(BorrowDetail::getId)
//        		.toList();
//
//        // Sending a GET request to check inventory availability
//            URI fullUri = UriComponentsBuilder.fromUriString("http://localhost:9020/api/inventory")
//                    .queryParam("bookId", bookIds)
//                    .build()
//                    .toUri();
//            System.out.println("Full URI: " + fullUri.toString());
//
//            InventoryResponse[] inventoryResponseArray = webClient.get()
//                    .uri(fullUri)
//                    .retrieve()
//                    .bodyToMono(InventoryResponse[].class)
//                    .block();
//
//            System.out.println(Arrays.toString(inventoryResponseArray));
//
//            if (Arrays.stream(inventoryResponseArray).anyMatch(response -> response.isInStock())) {
//                System.out.println("Inventory is available. Proceeding to borrow books.");
//                if (!entityManager.contains(borrow)) {
//                    borrow = entityManager.merge(borrow); // Re-attach đối tượng
//                }
//                borrowRepository.save(borrow);
//                return "Books borrowed successfully.";
//            } else {
//                System.out.println("Inventory not available. Unable to borrow books.");
//                throw new IllegalArgumentException("Book is not in stock, please try again later");
//            }
//    }
//}
//
//
package com.example.BorrowService.service;

import com.example.BorrowService.models.Borrow;
import com.example.BorrowService.repositories.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    public Borrow saveBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    public Borrow findBorrow(Long id) {
        return borrowRepository.findById(id).orElse(null);
    }
    // Thêm các phương thức khác theo nhu cầu
}
