package com.gradi.app.activities.mappers;

import com.gradi.app.activities.model.mediaRelated.MediaContentEntity;
import com.gradi.app.activities.model.mediaRelated.MediaDTO;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class MediaMapperImpl implements MediaMapperInterface {
    @Override
    public MediaContentEntity mapToMediaContentEntity(MediaDTO media) {
        var decodedBase64 = Base64.getDecoder().decode(media.getContent().substring(media.getContent().indexOf(",") + 1).getBytes(StandardCharsets.UTF_8));
        return new MediaContentEntity(decodedBase64, media.getContentType());
    }

    @Override
    public MediaDTO mapToMediaDTO(MediaContentEntity media) {
        var encodedToString = Base64.getEncoder().encodeToString(media.getContent());
        return new MediaDTO(encodedToString, media.getContentType());
    }
}
