package ru.asteises.imdbapi.model.dto;

import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieApiDto {

    private int rank;
    @Builder.Default
    private String title = "title is not available";
    @Builder.Default
    private String thumbnail = "thumbnail is not available";
    @Builder.Default
    private String rating = "rating is not available";
    @Builder.Default
    private String id = "id is not available";
    private int year;
    @Builder.Default
    private String image = "image is not available";
    @Builder.Default
    private String description = "description is not available";
    @Builder.Default
    private String trailer = "trailer is not available";
    private String[] genre;
    private String[] director;
    private String[] writers;
    @Builder.Default
    private String imdbid = "imdbid is not available";

    @Override
    public String toString() {
        return "MovieIncomeDto{" +
                "rank=" + rank +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", rating='" + rating + '\'' +
                ", id='" + id + '\'' +
                ", year=" + year +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", trailer='" + trailer + '\'' +
                ", genre=" + Arrays.toString(genre) +
                ", director=" + Arrays.toString(director) +
                ", writers=" + Arrays.toString(writers) +
                ", imdbid='" + imdbid + '\'' +
                '}';
    }
}
