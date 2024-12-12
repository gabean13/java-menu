package menu.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void getCategoryTest1() {
        int id = 1;
        Assertions.assertThat(Category.getCategory(id)).isEqualTo(Category.일식);
    }

}