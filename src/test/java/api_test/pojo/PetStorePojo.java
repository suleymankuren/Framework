package api_test.pojo;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

    @Getter
    @Setter
    public class PetStorePojo {
        long id;
        PetStoreCategoryPojo category;
        String name;
        List<String> photoUrls;
        String status;
        List<PetStoreTagsPojo> tags;
    }

