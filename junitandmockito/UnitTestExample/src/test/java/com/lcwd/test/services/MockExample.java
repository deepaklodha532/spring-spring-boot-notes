package com.lcwd.test.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class MockExample {

    @Mock
    private List<Integer> list;

    @Mock
    private Map<String , Integer> map  ;


    @Test
    public void runTest(){

        int listSize = 5 ;
        int keyAtZerothPostion = 32;

        Mockito.when(list.size()).thenReturn(5) ;

//        Mockito.when(map.get("first")).thenReturn(32) ;

        Assertions.assertEquals(listSize , list.size());
//        Assertions.assertEquals(keyAtZerothPostion , map.get("first"));
    }
}
