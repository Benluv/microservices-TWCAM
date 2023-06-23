package es.uv.bjtwcam.mongo.services;

import org.springframework.stereotype.Service;

import es.uv.bjtwcam.mongo.models.Analytics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AnalyticsService {
    private final String ANALYTICS_COLLECTION = "analytics";

    @Autowired
    MongoTemplate mongoTemplate;

    public void addUserAccess(String userId) {
        Analytics analytic = new Analytics();

        analytic.setUserId(userId);
        analytic.setUserLoginCount(1L);

        mongoTemplate.insert(analytic, ANALYTICS_COLLECTION);
        log.info("Mongo 2 " + userId);
    }
}