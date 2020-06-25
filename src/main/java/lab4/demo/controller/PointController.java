package lab4.demo.controller;

import lab4.demo.dao.PointRepository;
import lab4.demo.entity.Point;
import lab4.demo.service.AreaCheck;
import lab4.demo.service.PointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class PointController {
    private final PointRepository pointRepository;
    private final AreaCheck areaCheck;
    private final PointService pointService;
    private static final Logger logger = LoggerFactory.getLogger(PointController.class);

    PointController(PointRepository pointRepository, AreaCheck areaCheck, PointService pointService) {
        this.pointRepository = pointRepository;
        this.areaCheck = areaCheck;
        this.pointService=pointService;
    }

    @CrossOrigin
    @GetMapping("/api/getEntries")
    ResponseEntity<?> allPoints(Principal principal) {
        logger.info("in getEntries. name: "+principal.getName());
        return new ResponseEntity<>(
                pointRepository.findAllById(principal.getName()),
                HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/api/addEntry")
    ResponseEntity<?> newPoint(@RequestBody Point newPoint, Principal principal) {
        if (!areaCheck.isGood(newPoint)){
            throw new ResourceException(HttpStatus.BAD_REQUEST,"Неверный формат данных");
        }
        newPoint.setHit(areaCheck.isInArea(newPoint));
        newPoint.setUsername(principal.getName());
        pointService.addNewPoint(newPoint);
        return new ResponseEntity<>(
                pointRepository.save(newPoint),
                HttpStatus.OK);
    }

}
