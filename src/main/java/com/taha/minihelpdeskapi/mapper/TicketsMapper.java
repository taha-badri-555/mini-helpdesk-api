package com.taha.minihelpdeskapi.mapper;

import com.taha.minihelpdeskapi.dto.ticket.RequestTicket;
import com.taha.minihelpdeskapi.dto.ticket.ResponseTicket;
import com.taha.minihelpdeskapi.entity.Ticket;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        builder = @org.mapstruct.Builder(disableBuilder = true))

public interface TicketsMapper extends BaseMapper<RequestTicket, ResponseTicket, Ticket> {


    @Override
    RequestTicket entityToRequest(Ticket entity);

    @Override
    Ticket requestToEntity(RequestTicket dto);

    @Override
    void updateEntityWithRequest(RequestTicket dto, @MappingTarget Ticket entity);

    @Override
    @Mapping(source = "creatorUserId", target = "createdBy.id")
    Ticket responseToEntity(ResponseTicket dto);

    @Override
    @Mapping (source = "createdBy.id",target = "creatorUserId")
    ResponseTicket entityToResponse(Ticket entity);
}
