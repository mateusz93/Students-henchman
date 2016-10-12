package service;

import cdm.DeansGroupRS;
import model.DeansGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.DeansGroupRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Mateusz Wieczorek on 10/12/16.
 */
@Service
public class DeansGroupServiceImpl implements DeansGroupService {

    private static final Logger log = LoggerFactory.getLogger(DeansGroupService.class);

    @Autowired
    private DeansGroupRepository repository;

    @Override
    public DeansGroupRS prepareResultForGetDeansGroupByName(HttpServletResponse httpResponse, String name) {
        log.info("PathParameter: Name=" + name);
        DeansGroupRS result = new DeansGroupRS();
        DeansGroup deansGroup = repository.findByName(name);
        if (deansGroup != null) {
            result.getDeansGroups().add(deansGroup);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public DeansGroupRS prepareResultForGetDeansGroupById(HttpServletResponse httpResponse, String id) {
        log.info("PathParameter: id=" + id);
        DeansGroupRS result = new DeansGroupRS();
        DeansGroup deansGroup = repository.findById(Long.valueOf(id));
        if (deansGroup != null) {
            result.getDeansGroups().add(deansGroup);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        } else {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }

    @Override
    public DeansGroupRS prepareResultForGetDeansGroups(HttpServletResponse httpResponse) {
        DeansGroupRS result = new DeansGroupRS();
        List<DeansGroup> deansGroups = (List<DeansGroup>) repository.findAll();
        if (CollectionUtils.isEmpty(deansGroups)) {
            httpResponse.setStatus(HttpStatus.NOT_FOUND.value());
        } else {
            result.getDeansGroups().addAll(deansGroups);
            httpResponse.setStatus(HttpStatus.FOUND.value());
        }
        log.info("ResponseBody: " + result.toString());
        return result;
    }
}
