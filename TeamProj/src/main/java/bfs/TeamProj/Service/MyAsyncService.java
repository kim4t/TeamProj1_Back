package bfs.TeamProj.Service;

import bfs.TeamProj.domain.Address;
import bfs.TeamProj.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class MyAsyncService {
    @Autowired
    PersonService personService;
    @Autowired
    AddressService addressService;

    public List<Address> getAllAddress() throws ExecutionException, InterruptedException {
        System.out.println("In my service");
        CompletableFuture<List<Address>> list1 = addressService.getAllAddressAsync();
        CompletableFuture<List<Address>> list2 = addressService.getAllAddressAsync();
        CompletableFuture<List<Address>> list3 = addressService.getAllAddressAsync();
        CompletableFuture<List<Address>> list4 = addressService.getAllAddressAsync();
        CompletableFuture<List<Address>> list5 = addressService.getAllAddressAsync();
        CompletableFuture<Void> res = CompletableFuture.allOf(list1, list2, list3, list4, list5);
        //.thenRun(() -> { System.out.println("hello"); });
        list1.get();
        System.out.println(list1.isDone());
        //System.out.println(list1.get().toString());
        return list1.get();
    }


}
