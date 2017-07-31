package app.gamestore.command.commands;

import app.gamestore.command.BaseCommand;
import app.gamestore.dto.bindingDtos.game.ShoppingCartGame;
import app.gamestore.dto.bindingDtos.user.LoggedInUser;
import app.gamestore.dto.bindingDtos.user.ShoppingCartUser;
import app.gamestore.services.api.GameService;
import app.gamestore.services.api.UserService;
import app.gamestore.utils.Session;

public class AddToShoppingCart extends BaseCommand {

    public AddToShoppingCart(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        LoggedInUser loggedInUser = Session.getLoggedInUser();

        if (loggedInUser == null) {
            return "There is currently no logged in user";
        }

        String title = params[0];

        ShoppingCartGame shoppingCartGame = super.getGameService().shopByTitle(title);

        ShoppingCartUser shoppingCartUser = super.getUserService().findById(loggedInUser.getId());

        if(shoppingCartUser.addGameToCart(shoppingCartGame)) {
            this.getUserService().persistShoppingCartUser(shoppingCartUser);
            return shoppingCartGame.getTitle() + " added to cart.";
        }

        return "User has bought this game";
    }
}
