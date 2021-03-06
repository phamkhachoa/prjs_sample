/**
 * 
 */
package jp.co.softbrain.esales.commons.web.rest.vm.request;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Request for GetImportProgressBar API
 * @author dohuyhai
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class GetImportProgressBarRequest implements Serializable {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1593384147784462395L;
    
    /**
     * import Id
     */
    private Long importId;

}
