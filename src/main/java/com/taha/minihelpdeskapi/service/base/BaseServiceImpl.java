package com.taha.minihelpdeskapi.service.base;

import com.taha.minihelpdeskapi.entity.BaseEntity;
import com.taha.minihelpdeskapi.mapper.BaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@RequiredArgsConstructor
public class BaseServiceImpl<
        T extends BaseEntity,
        Q,
        S,
        M extends BaseMapper<Q, S, T>,
        R extends JpaRepository<T, Long>
        > implements BaseService<T,Q> {

    public final R repository;
    public final M mapper;


    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update (T entity ,Q request) {
        mapper.updateEntityWithRequest(request, entity);
        return repository.save(entity);
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public T deleteById(Long id) {
        var byId = findById(id);
        repository.deleteById(byId.getId());
        return byId;
    }
}
