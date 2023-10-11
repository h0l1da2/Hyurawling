package app.rakuten.hyurawling.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramFields {

    private String url;
    private int minPage;
    private int maxPage;
    private int margin;
    private int coupangCommission;
    private int delivery;
    private String fileName;
    private String folderPath;
}
