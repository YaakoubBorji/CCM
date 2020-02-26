package com.yaakoub.cryptocurrencymarket.helper;

import com.yaakoub.cryptocurrencymarket.model.ModelApiResponse;

public class Helper {


    public static ModelApiResponse generateReponse(String action) {
        ModelApiResponse modelApiResponse = new ModelApiResponse();

        switch (action) {
            case "CREATE":
                modelApiResponse.setCode(200);
                modelApiResponse.setMessage("Created successfully");
                modelApiResponse.setType("create");
                break;
            case "DELETE":
                modelApiResponse.setCode(200);
                modelApiResponse.setMessage("Deleted successfully");
                modelApiResponse.setType("delete");
                break;
            case "BUY":
                modelApiResponse.setCode(200);
                modelApiResponse.setMessage("Updated successfully");
                modelApiResponse.setType("update");
                break;

        }

        return modelApiResponse;
    }
}
