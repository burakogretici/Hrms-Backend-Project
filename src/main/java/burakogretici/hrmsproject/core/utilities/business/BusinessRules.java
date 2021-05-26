package burakogretici.hrmsproject.core.utilities.business;

import burakogretici.hrmsproject.core.utilities.results.Result;


public class BusinessRules {
    public static Result run(Result... logics) {
        for (Result logic : logics) {
            if (!logic.isSuccess()) {
                return logic;
            }
        }
        return null;
    }

}


