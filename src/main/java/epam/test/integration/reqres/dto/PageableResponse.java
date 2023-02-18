package epam.test.integration.reqres.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageableResponse<T> {

    private Long page;

    private Long perPage;

    private Long total;

    private Long totalPages;

    private List<T> data;
}
