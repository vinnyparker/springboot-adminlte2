package br.com.venustech.service;

import br.com.venustech.model.Pais;
import br.com.venustech.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PaisService extends AbstractService<Pais, Long> {

    private static final int PAGE_SIZE = 10;
    @Autowired
    private PaisRepository paisRepository;

    @Override
    protected JpaRepository<Pais, Long> getRepository() {
        return paisRepository;
    }

    public Page<Pais> getCustomList(Integer pageNumber) {
        PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id");

        return getRepository().findAll(pageRequest);
    }

}
