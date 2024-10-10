package com.lcwd.test.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class GstServiceTest {

    @Mock
    private GstProvider mockProvider ;

    @InjectMocks
    private GSTService gstService ;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void gstCalculateTest(){


//        GSTService gstService = new GSTService(provider) ;
        Mockito.when(mockProvider.getGSTDetail()).thenReturn(18) ;
        int actualResult = gstService.calculateGST() ;

        Assertions.assertEquals(18, actualResult) ;

    }
}

//class GSTProviderImpl implements GstProvider {
//
//
//    @Override
//    public int getGSTDetail() {
//        return 0;
//    }
//}
