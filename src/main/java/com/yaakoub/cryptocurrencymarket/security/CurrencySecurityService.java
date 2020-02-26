package com.yaakoub.cryptocurrencymarket.security;

import com.yaakoub.cryptocurrencymarket.model.Position;
import com.yaakoub.cryptocurrencymarket.model.User;
import com.yaakoub.cryptocurrencymarket.repository.PositionRepository;
import com.yaakoub.cryptocurrencymarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencySecurityService<T> {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    UserRepository userRepository;

    /**
     * generic function for authorities
     * @param object
     * @param id
     * @return
     */
    public boolean canDoAction(T object, Object id) {
        //we need to know if position are created by the current user
        ServerSideUser principal = authenticationService.getServerSideUser();
        if (object instanceof Position) {
            Position position = positionRepository.findPositionById((Long)id);
            if (position != null && position.getUser().getUserName().equalsIgnoreCase(principal.getUsername()))
                return true;
        } else if (object instanceof User) {
            User user = userRepository.findByuserName((String)id);
            if (user != null && user.getUserName().equalsIgnoreCase(principal.getUsername()))
                return true;
        }

        return false;
    }
}
