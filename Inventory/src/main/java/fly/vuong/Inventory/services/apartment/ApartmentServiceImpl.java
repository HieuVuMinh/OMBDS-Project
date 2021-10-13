package fly.vuong.Inventory.services.apartment;

import fly.vuong.Inventory.entities.Apartment;
import fly.vuong.Inventory.entities.Area;
import fly.vuong.Inventory.entities.Building;
import fly.vuong.Inventory.entities.dto.ApartmentDto;
import fly.vuong.Inventory.repositories.ApartmentRepository;
import fly.vuong.Inventory.repositories.AreaRepository;
import fly.vuong.Inventory.repositories.BuildingRepository;
import fly.vuong.Inventory.request.AddApartmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    ApartmentRepository apartmentRepository;

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Override
    public ApartmentDto createApartment(AddApartmentRequest request) {
        Apartment apartment = new Apartment();
        apartment.setApartmentId(UUID.randomUUID());
        apartment.setPrice(request.getPrice());
        apartment.setSuperficies(request.getSuperficies());
        apartment.setBedRoom(request.getBedRoom());
        apartment.setStatus(true);
        apartmentRepository.save(apartment);
        return convertFromApartment(apartment);
    }

    @Override
    public ApartmentDto findById(UUID id) {
        return convertFromApartment(apartmentRepository.getById(id));
    }

    @Override
    public List<ApartmentDto> findAll() {
        return convertFromListApartment(apartmentRepository.findAll());
    }

    @Override
    public List<ApartmentDto> findByBuildingId(UUID id) {
        return findByBuilding(buildingRepository.findById(id).get());
    }

    @Override
    public List<ApartmentDto> findByAreaId(UUID id) {
        return findByArea(areaRepository.findById(id).get());
    }

    @Override
    public List<ApartmentDto> findByBuilding(Building building) {
        //TODO: code logic
        return null;
    }

    @Override
    public List<ApartmentDto> findByArea(Area area) {
        //TODO: code logic
        return null;
    }

    public ApartmentDto convertFromApartment(Apartment apartment) {
        //TODO: check code logic
        ApartmentDto apartmentDto = new ApartmentDto();
        apartmentDto.setId(apartment.getApartmentId());
        apartmentDto.setAddress(apartment.getAddress());
        apartmentDto.setBedRoom(apartment.getBedRoom());
        apartmentDto.setOwnerId(apartment.getOwnerId());
        apartmentDto.setPrice(apartment.getPrice());
        apartmentDto.setSuperficies(apartment.getSuperficies());
        return apartmentDto;
    }

    public List<ApartmentDto> convertFromListApartment(List<Apartment> apartments) {
        List<ApartmentDto> apartmentDtos = new ArrayList<>();
        apartments.forEach(apartment -> apartmentDtos.add(convertFromApartment(apartment)));
        return apartmentDtos;
    }
}
