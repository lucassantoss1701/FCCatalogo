package com.fullcycle.FCCatalogo.domain.entity;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryTests {

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsNull(){
        assertThrows(IllegalArgumentException.class, ()-> new Category((String) null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenIdIsNull(){
        assertThrows(IllegalArgumentException.class, ()-> new Category((UUID) null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlank(){
        assertThrows(IllegalArgumentException.class, ()-> new Category(""));
    }

    @Test
    public void createCategory(){
        final Category entity = new Category("Category 1");
        assertNotNull(entity);
        assertEquals(entity.getName(), "Category 1");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

}
