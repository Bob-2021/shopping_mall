package bob.shopping_mall.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ***
 * 2023-05-29 23:11
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {
    private Set<Integer> set = new HashSet<>();
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals = constraintAnnotation.vals();
        for(int v : vals){
            set.add(v);
        }
    }

    @Override
    public boolean isValid(Integer v, ConstraintValidatorContext constraintValidatorContext) {
        return set.contains(v);
    }
}
