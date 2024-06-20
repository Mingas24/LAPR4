/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.ExportXML.*;
import eapli.base.app.backoffice.console.presentation.ImportMessages.ImportAction;
import eapli.base.app.backoffice.console.presentation.MachineConfigurationFile.ConfigurationFileAction;
import eapli.base.app.backoffice.console.presentation.Machines.MachineAction;
import eapli.base.app.backoffice.console.presentation.Product.AddProductAction;
import eapli.base.app.backoffice.console.presentation.ProductionLine.CreatePLAction;
import eapli.base.app.backoffice.console.presentation.ProductionLineProcessing.PLProcessingAction;
import eapli.base.app.backoffice.console.presentation.ProductionOrder.IntroduceProductionOrderAction;
import eapli.base.app.backoffice.console.presentation.ProductionOrderByOrderID.ListProductionOrderByOrderIDAction;
import eapli.base.app.backoffice.console.presentation.ProductionOrderByState.ListProductionOrderByStateAction;
import eapli.base.app.backoffice.console.presentation.ProductionSheet.SpecifyProductionSheetAction;
import eapli.base.app.backoffice.console.presentation.RequestConfig.RequestConfigAction;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.category.CreateCATAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.app.backoffice.console.presentation.deposits.DefineDepositAction;
import eapli.base.app.backoffice.console.presentation.errorNotifications.ListFiledErrorNotificationsAction;
import eapli.base.app.backoffice.console.presentation.errorNotifications.ListUnhandledErrorNotificationsAction;
import eapli.base.app.backoffice.console.presentation.imports.ImportProductCatalogueAction;
import eapli.base.app.backoffice.console.presentation.imports.ImportProductionOrdersAction;
import eapli.base.app.backoffice.console.presentation.productsWithoutProductionSheet.ListProductsWithoutProductionSheetAction;
import eapli.base.app.backoffice.console.presentation.rawmaterial.CreateRMAction;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;

    // DISH TYPES
    private static final int DISH_TYPE_REGISTER_OPTION = 1;
    private static final int DISH_TYPE_LIST_OPTION = 2;
    private static final int DISH_TYPE_CHANGE_OPTION = 3;
    private static final int DISH_TYPE_ACTIVATE_DEACTIVATE_OPTION = 4;

    // DISHES
    private static final int DISH_REGISTER_OPTION = 5;
    private static final int DISH_LIST_OPTION = 6;
    private static final int DISH_REGISTER_DTO_OPTION = 7;
    private static final int DISH_LIST_DTO_OPTION = 8;
    private static final int DISH_ACTIVATE_DEACTIVATE_OPTION = 9;
    private static final int DISH_CHANGE_OPTION = 10;

    // DISH PROPERTIES
    private static final int CHANGE_DISH_NUTRICIONAL_INFO_OPTION = 1;
    private static final int CHANGE_DISH_PRICE_OPTION = 2;

    // MATERIALS
    private static final int MATERIAL_REGISTER_OPTION = 1;
    private static final int MATERIAL_LIST_OPTION = 2;

    // REPORTING
    private static final int REPORTING_DISHES_PER_DISHTYPE_OPTION = 1;
    private static final int REPORTING_HIGH_CALORIES_DISHES_OPTION = 2;
    private static final int REPORTING_DISHES_PER_CALORIC_CATEGORY_OPTION = 3;

    // MEALS
    private static final int LIST_MEALS_OPTION = 1;
    private static final int MEAL_REGISTER_OPTION = 2;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int SETTINGS_OPTION = 4;
    private static final int DEPOSITS_OPTION = 5;
    private static final int PRODLINE_OPTION = 6;
    private static final int IMPORT_FILE_OPTION = 7;
    private static final int PRODUCT_OPTION = 8;
    private static final int WITHOUT_PRODUCTION_SHEET_OPTION = 9;
    private static final int RAWMATERIAL_OPTION = 10;
    private static final int PRODUCTIONORDER_OPTION = 11;
    private static final int CONFIGURATION_FILE_OPTION = 12;
    private static final int EXPORT_TO_XML = 13;
    private static final int IMPORT_MESSAGES = 14;
    private static final int ERROR_NOTIFICATIONS_OPTION = 15;
    private static final int TRANSF_XML = 16;


    //  CATEGORY
    private static final int ADD_CATEGORY = 1;
    private static final int ADD_RAWMATERIAL = 2;

    // DEPOSIT
    private static final int DEFINE_DEPOSIT_OPTION = 1;

    //Production Line
    private static final int CREATE_PRODUCTION_LINE = 1;
    private static final int CREATE_MACHINE = 2;
    private static final int CHECK_PROCESSING_STATE = 3;

    //Import CSV
    private static final int IMPORT_PRODUCT_CATALOGUE = 1;
    private static final int IMPORT_PRODUCTION_ORDERS = 2;

    //List Products Without Production Sheet
    private static final int SHOW_LIST = 1;

    //Product
    private static final int CREATE_PRODUCT = 1;
    private static final int SPECIFY_PRODUCTION_SHEET = 2;

    //ProductionOrder
    private static final int CREATE_PRODUCTION_ORDER = 1;
    private static final int LIST_PRODUCTION_ORDER_AT_GIVEN_STATE = 2;
    private static final int LIST_PRODUCTION_ORDER_BY_ID = 3;

    //Machine
    private static final int SPECIFY_CONFIGURATION_FILE = 1;
    private static final int REQUEST_CONFIG = 2;

    //Export XML
    private static final int EXPORT = 1;

    //Import Messages
    private static final int IMPORT = 1;

    //ErrorNotifications
    private static final int LIST_UNHANDLED_NOTIFICATIONS = 1;
    private static final int LIST_FILED_NOTIFICATIONS = 2;

    //TransformXmlToHtml
    private static final int TRANSFORM_COMPLETE_INFO_HTML = 1;
    private static final int TRANSFORM_X_INFO_HTML = 2;
    private static final int TRANSFORM_Y_INFO_HTML = 3;
    private static final int TRANSFORM_COMPLETE_INFO_TXT = 4;
    private static final int TRANSFORM_X_INFO_TXT = 5;
    private static final int TRANSFORM_Y_INFO_TXT = 6;
    private static final int TRANSFORM_COMPLETE_INFO_JSON = 7;
    private static final int TRANSFORM_MACHINES_INFO_JSON = 8;
    private static final int TRANSFORM_PRODUCTS_INFO_JSON = 9;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
            final Menu depositMenu = buildDepositMenu();
            mainMenu.addSubMenu(DEPOSITS_OPTION, depositMenu);
            final Menu productLineMenu = buildProdLineMenu();
            mainMenu.addSubMenu(PRODLINE_OPTION, productLineMenu);
            final Menu importMenu = buildImportMenu();
            mainMenu.addSubMenu(IMPORT_FILE_OPTION, importMenu);
            final Menu productMenu = buildProductMenu();
            mainMenu.addSubMenu(PRODUCT_OPTION, productMenu);
            final Menu withoutProductionSheetMenu = buildWithoutProductionSheetMenu();
            mainMenu.addSubMenu(WITHOUT_PRODUCTION_SHEET_OPTION, withoutProductionSheetMenu);
            final Menu categoryMenu = buildCategoryMenu();
            mainMenu.addSubMenu(RAWMATERIAL_OPTION, categoryMenu);
            final Menu productionOrderMenu = buildProductionOrderMenu();
            mainMenu.addSubMenu(PRODUCTIONORDER_OPTION, productionOrderMenu);
            final Menu machineMenu = buildMachineMenu();
            mainMenu.addSubMenu(CONFIGURATION_FILE_OPTION, machineMenu);
            final Menu exportXMLMenu = buildExportXMLMenu();
            mainMenu.addSubMenu(EXPORT_TO_XML, exportXMLMenu);
            mainMenu.addItem(IMPORT_MESSAGES, "Import the messages", new ImportAction());
            final Menu errorNotificationsMenu = buildErrorNotificationsMenu();
            mainMenu.addSubMenu(ERROR_NOTIFICATIONS_OPTION, errorNotificationsMenu);
            final Menu transformXml = buildTransformXmlFile();
            mainMenu.addSubMenu(TRANSF_XML, transformXml);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildTransformXmlFile() {
        final Menu menu = new Menu("-Transform XML file-");

        menu.addItem(TRANSFORM_COMPLETE_INFO_HTML, "Transform -complete- information to HTML", new XMLtoHTMLCompleteAction());
        menu.addItem(TRANSFORM_X_INFO_HTML, "Transform -only Raw Materials with tech sheet- information to HTML", new XMLtoHTMLOnlyRawMatWithTechSheetAction());
        menu.addItem(TRANSFORM_Y_INFO_HTML, "Transform -only Products with Unit as KG- information to HTML", new XMLtoHTMLUnityKGAction());
        menu.addItem(TRANSFORM_COMPLETE_INFO_TXT, "Transform -complete- information to TXT (CSV)", new XMLtoTXTCompleteAction());
        menu.addItem(TRANSFORM_X_INFO_TXT, "Transform -only Products with Unit as KG- information to TXT", new XMLtoTXTUnityKGCSVAction());
        menu.addItem(TRANSFORM_Y_INFO_TXT, "Transform -only PLs with Machines- information to TXT", new XMLtoTXTOnlyPLsWithMachinesAction());
        menu.addItem(TRANSFORM_COMPLETE_INFO_JSON, "Transform complete information to JSON", new XMLtoJSONCompleteAction());
        menu.addItem(TRANSFORM_MACHINES_INFO_JSON, "Transform machines information to JSON", new XMLtoJSONMachinesAction());
        menu.addItem(TRANSFORM_PRODUCTS_INFO_JSON, "Transform products information to JSON", new XMLtoJSONProductsAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildDepositMenu() {
        final Menu menu = new Menu("-Deposits-");

        menu.addItem(DEFINE_DEPOSIT_OPTION, "Define a new deposit", new DefineDepositAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildProdLineMenu() {
        final Menu menu = new Menu("-Production Line-");

        menu.addItem(CREATE_PRODUCTION_LINE, "Create a new Production Line", new CreatePLAction());
        menu.addItem(CREATE_MACHINE, "Create a new Machine", new MachineAction());
        menu.addItem(CHECK_PROCESSING_STATE, "Check the processing state for each Production Line", new PLProcessingAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildProductMenu() {
        final Menu menu = new Menu("-Product-");

        menu.addItem(CREATE_PRODUCT, "Create a new Product", new AddProductAction());
        menu.addItem(SPECIFY_PRODUCTION_SHEET, "Specify Production Sheet", new SpecifyProductionSheetAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildImportMenu() {
        final Menu menu = new Menu("-Import a file-");

        menu.addItem(IMPORT_PRODUCT_CATALOGUE, "Import Product Catalogue", new ImportProductCatalogueAction());
        menu.addItem(IMPORT_PRODUCTION_ORDERS, "Import Production Orders", new ImportProductionOrdersAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildWithoutProductionSheetMenu() {
        final Menu menu = new Menu("-List Products Without Production Sheet-");

        menu.addItem(SHOW_LIST, "LIST:", new ListProductsWithoutProductionSheetAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCategoryMenu() {
        final Menu menu = new Menu("-Add Category-");
        menu.addItem(ADD_CATEGORY, "Add Category", new CreateCATAction());
        menu.addItem(ADD_RAWMATERIAL, "Add Raw Material", new CreateRMAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildProductionOrderMenu() {
        final Menu menu = new Menu("-Production Order-");
        menu.addItem(CREATE_PRODUCTION_ORDER, "Introduce a New Production Order", new IntroduceProductionOrderAction());
        menu.addItem(LIST_PRODUCTION_ORDER_AT_GIVEN_STATE, "List Production Order At Given State", new ListProductionOrderByStateAction());
        menu.addItem(LIST_PRODUCTION_ORDER_BY_ID, "List Production Order By ID", new ListProductionOrderByOrderIDAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildMachineMenu() {
        final Menu menu = new Menu("-Machine-");
        menu.addItem(SPECIFY_CONFIGURATION_FILE, "Specify configuration file", new ConfigurationFileAction());
        menu.addItem(REQUEST_CONFIG, "Request a Configuration adittion", new RequestConfigAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildExportXMLMenu() {
        final Menu menu = new Menu("-Export to XML File-");
        menu.addItem(EXPORT, "Export all factory floor information", new ExportFactoryFloorToXMLAction());

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildErrorNotificationsMenu() {
        final Menu menu = new Menu("-Error Notifications-");
        menu.addItem(LIST_UNHANDLED_NOTIFICATIONS, "List Unhandled Notifications", new ListUnhandledErrorNotificationsAction());
        menu.addItem(LIST_FILED_NOTIFICATIONS, "List Filed Notifications", new ListFiledErrorNotificationsAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);
        return menu;
    }
}
