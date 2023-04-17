package com.ex.app.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.ex.app.models.Asemat;
import com.ex.app.repository.AsemaPaginationRepository;
import com.ex.app.repository.AsematRepository;

public class AsemaServiceTest {

    @Mock
    private AsemaPaginationRepository asematPaginationRepository;
    
    @Mock
    private AsematRepository asematRepository;

    @InjectMocks
    private AsemaService asemaService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void testGetAllStations() {
        List<Asemat> asematList = new ArrayList<>();
        asematList.add(new Asemat(9876543210L, 9876543210L,"test","test","test","helsinki","helsinki","helsinki","helsinki","helsinki",1,5.5,5.5));
        Page<Asemat> page = new PageImpl<>(asematList);

        when(asematPaginationRepository.findAll(PageRequest.of(1, 100, Sort.by("name")))).thenReturn(page);

        Page<Asemat> result = asemaService.getAllStations("name", 1);

        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        assertEquals("test", result.getContent().get(0).getName());
    }

    @Test
    public void testGetAllStationsJourneysSearchedByCapacity() {
        List<Asemat> asematList = new ArrayList<>();
        asematList.add(new Asemat(9876543210L, 9876543210L,"test","test","test","helsinki","helsinki","helsinki","helsinki","helsinki",1,5.5,5.5));
        Page<Asemat> page = new PageImpl<>(asematList);

        when(asematPaginationRepository.searchAsematByCapacity(200, PageRequest.of(1, 100, Sort.by("id")))).thenReturn(page);

        Page<Asemat> result = asemaService.getAllStationsJourneysSearchedByCapacity(200);

        assertNotNull(result);
        assertEquals(1, result.getContent().size());
        assertEquals("test", result.getContent().get(0).getName());
    }

    @Test
    public void testGetStationById() {
        Optional<Asemat> asemaOptional = Optional.of(new Asemat(9876543210L, 9876543210L,"test","test","test","helsinki","helsinki","helsinki","helsinki","helsinki",1,5.5,5.5));

        when(asematRepository.findById(1L)).thenReturn(asemaOptional);

        Optional<Asemat> result = asemaService.getStationById(1L);

        assertNotNull(result);
    }
}
