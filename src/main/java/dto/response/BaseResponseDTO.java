package dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class BaseResponseDTO implements Serializable {
    ErrorDTO errorDTO;
}
