package com.crud.PracticandoDWEC.mappers;

public interface IMapper <I, O>{
    O mapearEntidad(I in);
    I mapearDto(O out);
}
