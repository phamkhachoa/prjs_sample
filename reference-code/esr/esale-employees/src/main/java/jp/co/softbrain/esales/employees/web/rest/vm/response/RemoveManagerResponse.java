/**
 * 
 */
package jp.co.softbrain.esales.employees.web.rest.vm.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author dohuunam
 *
 */
@Data
public class RemoveManagerResponse implements Serializable {
    /**
     * 
     * serialVersionUID
     */
    private static final long serialVersionUID = -4457385307347343191L;
    private List<Long> list;
}
