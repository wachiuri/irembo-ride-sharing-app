package com.irembo.ride.driveronboarding.base;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import reactor.core.publisher.Mono;

@Slf4j
public abstract class BaseService<T, ID> {

    protected abstract <S extends BaseRepository<T, ID>> S getRepository();

    public Mono<Page<T>> findAll(int pageIndex, int size) {
        return getRepository()
                .findAllBy(PageRequest.of(pageIndex, size))
                .collectList()
                .zipWith(this.getRepository().count())
                .map(t -> new PageImpl<>(t.getT1(), PageRequest.of(pageIndex, size), t.getT2()))
                ;
    }

    public Mono<T> findById(ID id) {
        return getRepository().findById(id);
    }

    public Mono<Void> deleteById(ID id) {
        return getRepository().deleteById(id);
    }

    public Mono<T> save(T entity) {
        return getRepository().save(entity);
    }

}
