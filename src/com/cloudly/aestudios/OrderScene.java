package com.cloudly.aestudios;


import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class OrderScene extends Application {

    private static double xOffset = 0;
    private static double yOffset = 0;
    public String additemname , additemprice;
    public String dollarsign = "$" ;


    public TableView searchresults = new TableView() ;
    public TableView cartitems = new TableView() ;
    public TableView customertable = new TableView() ;



    @Override
    public void start(Stage MainStage) {




        Image exiticon = new Image("com//cloudly//aestudios//Files//Background//exit.png") ;
        Image minimizeicon = new Image("com//cloudly//aestudios//Files//Background//minimize.png") ;
        Button menubutton = new Button("G") ;
        Button exitbutton = new Button() ;
        Button minimizebutton = new Button() ;
        exitbutton.setGraphic(new ImageView(exiticon));
        minimizebutton.setGraphic(new ImageView(minimizeicon));






        // MAINBACKGROUND  &&&  LOGO  !!!!!!!!

        Image mainbackground = new Image("com//cloudly//aestudios//Files//Background//mainbackground.png") ;
        ImageView mainbackgrounddisplay = new ImageView(mainbackground) ;
        mainbackgrounddisplay.setFitWidth(1200);
        mainbackgrounddisplay.setFitHeight(700);


        Image mainlogo = new Image("com//cloudly//aestudios/Files//Background//mainlogo.png") ;
        ImageView mainlogodisplay = new ImageView(mainlogo) ;
        mainlogodisplay.setFitWidth(200);
        mainlogodisplay.setFitHeight(200);



        // GENERAL1 HERE !!!

        Label general1label = new Label("Items") ;
        Image icon1 = new Image("com//cloudly//aestudios//Files//Background//ordergeneral1icon.png") ;
        ImageView general1icon = new ImageView(icon1) ;
        general1icon.setFitWidth(100);
        general1icon.setFitHeight(100);

        HBox general1 = new HBox(general1icon , general1label) ;


        // GENERAL2 HERE !!!

        Label general2label = new Label("Order") ;
        Image icon2 = new Image("com//cloudly//aestudios//Files//Background//ordergeneral2icon.png") ;
        ImageView general2icon = new ImageView(icon2) ;
        general2icon.setFitWidth(100);
        general2icon.setFitHeight(100);

        HBox general2 = new HBox(general2label , general2icon) ;



        // GENERAL3 HERE !!!

        Label general3label = new Label("Clients") ;
        Image icon3 = new Image("com//cloudly//aestudios//Files//Background//ordergeneral3icon.png") ;
        ImageView general3icon = new ImageView(icon3) ;
        general3icon.setFitWidth(100);
        general3icon.setFitHeight(100);

        HBox general3 = new HBox(general3label , general3icon) ;








        StackPane orderstackpane = new StackPane() ;
        orderstackpane.getChildren().addAll(mainbackgrounddisplay , mainlogodisplay , exitbutton , minimizebutton , menubutton , general1 , general2 , general3) ;









        exitbutton.getStyleClass().add("exitbutton") ;
        minimizebutton.getStyleClass().add("minimizebutton") ;
        menubutton.getStyleClass().add("menubutton") ;
        mainbackgrounddisplay.getStyleClass().add("mainbackgrounddisplay") ;
        mainlogodisplay.getStyleClass().add("mainlogodisplay") ;
        general1.getStyleClass().add("general1") ;
        general2.getStyleClass().add("general2") ;
        general3.getStyleClass().add("general3") ;
        general1label.getStyleClass().add("general1label") ;
        general2label.getStyleClass().add("general2label") ;
        general3label.getStyleClass().add("general3label") ;
        general1icon.getStyleClass().add("general1icon") ;
        general2icon.getStyleClass().add("general2icon") ;
        general3icon.getStyleClass().add("general3icon") ;





        Scene orderscene = new Scene(orderstackpane , 1200 , 700) ;
        orderscene.getStylesheets().add(getClass().getResource("OrderScene.css").toExternalForm()) ;




        MainStage.setTitle("Green");
        MainStage.setScene(orderscene);








        //NavigationBar HERE !!!!!!!!!!!!!!    *****************************************************************







        HBox MenuRoot = new HBox();
        VBox menubar = new VBox();




        // ADD ITEMS FOR MENUBAR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


        Image mainlogomenubar = new Image("com//cloudly//aestudios//Files//Background//mainlogomenubar.png") ;
        ImageView mainlogomenubardisplay = new ImageView(mainlogomenubar) ;
        mainlogomenubardisplay.setFitWidth(300);
        mainlogomenubardisplay.setFitHeight(800);
        Image backarrow = new Image("com//cloudly//aestudios//Files//Background//undo.png") ;
        Button backbutton = new Button();
        backbutton.setGraphic(new ImageView(backarrow));
        Button homebutton = new Button("Home");
        Button factorbutton = new Button("Factor");
        Button orderbutton = new Button("Order");
        Button bankbutton = new Button("Bank") ;
        Button morebutton = new Button("More") ;







        menubar.getStyleClass().add("menubar") ;
        MenuRoot.getStyleClass().add("MenuRoot") ;
        backbutton.getStyleClass().add("backbutton-menubar") ;
        homebutton.getStyleClass().add("homebutton-menubar");
        factorbutton.getStyleClass().add("factorbutton-menubar") ;
        orderbutton.getStyleClass().add("orderbutton-menubar") ;
        bankbutton.getStyleClass().add("bankbutton-menubar") ;
        morebutton.getStyleClass().add("morebutton-menubar") ;
        mainlogomenubardisplay.getStyleClass().add("mainlogomenubardisplay") ;








        menubar.getChildren().addAll(mainlogomenubardisplay , backbutton , homebutton , factorbutton , orderbutton , bankbutton , morebutton);
        VBox.setVgrow(homebutton , Priority.ALWAYS);
        MenuRoot.getChildren().add(menubar);



        // NAVIGATIONBAR EVENT HANDELERS *****************


        backbutton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                FadeTransition hideFileRootTransition = new FadeTransition(Duration.millis(500), MenuRoot);
                hideFileRootTransition.setFromValue(1.0);
                hideFileRootTransition.setToValue(0.0);

                FadeTransition showEditorRootTransition = new FadeTransition(Duration.millis(500));
                showEditorRootTransition.setFromValue(0.0);
                showEditorRootTransition.setToValue(1.0);

                showEditorRootTransition.play();
                hideFileRootTransition.play();
                orderstackpane.getChildren().remove(MenuRoot);
            }
        });



        menubutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                orderstackpane.getChildren().add(MenuRoot);
                FadeTransition hideEditorRootTransition = new FadeTransition(Duration.millis(500));
                hideEditorRootTransition.setFromValue(1.0);
                hideEditorRootTransition.setToValue(0.0);

                FadeTransition showFileRootTransition = new FadeTransition(Duration.millis(500), MenuRoot);
                showFileRootTransition.setFromValue(0.0);
                showFileRootTransition.setToValue(1.0);
                hideEditorRootTransition.play();
                showFileRootTransition.play();
            }
        });












        // MAKES DRAGGING BRO !!!!!!!!!!!



        orderstackpane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = MainStage.getX() - event.getScreenX();
                yOffset = MainStage.getY() - event.getScreenY();
            }
        });

        orderstackpane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MainStage.setX(event.getScreenX() + xOffset);
                MainStage.setY(event.getScreenY() + yOffset);
            }
        });








        // EXIT &&& MINIMIZE BUTTONS HANDELER !!!!!!!!!!!



        exitbutton.setOnAction(e -> { Platform.exit(); });
        minimizebutton.setOnAction(e -> MainStage.setIconified(true));




        // SCENE CHANGER HERE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!







        factorbutton.setOnAction(e -> {

            FactorScene factorscene = new FactorScene() ;

            factorscene.start(MainStage);


        });



        bankbutton.setOnAction(e -> {

            BankScene bankScene = new BankScene() ;

            bankScene.start(MainStage);


        });


        morebutton.setOnAction(e -> {

            MoreScene moreScene = new MoreScene() ;


            moreScene.start(MainStage);




        });





        // SCENES FOR FACTOR MAKING AND STUFFS!!!!!@@@@@@@@@@@@@@@@@!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@############################################
        // MINI ONE
        // MINI ONE



        general1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            private double xOffset = 0;
            private double yOffset = 0;



            @Override
            public void handle(MouseEvent event) {



                Image minibackground = new Image("com//cloudly//aestudios//Files//Background//minisbackground.png") ;
                Image mininav = new Image("com//cloudly//aestudios//Files//Background//ministopnavigation.png") ;
                Image exticon = new Image("com//cloudly//aestudios//Files//Background//exiticonminis.png") ;
                Image mnimzeicon = new Image("com//cloudly//aestudios//Files//Background//minisminimizeicon.png") ;
                Image loveicon = new Image("com//cloudly//aestudios//Files//Background//additemicon1.png") ;
                ImageView minibackgrounddisplay = new ImageView(minibackground) ;
                Button exitbuttonmini = new Button() ;
                Button minimizebuttonmini = new Button() ;
                exitbuttonmini.setGraphic(new ImageView(exticon));
                minimizebuttonmini.setGraphic(new ImageView(mnimzeicon));
                minibackgrounddisplay.setFitWidth(600);
                minibackgrounddisplay.setFitHeight(600);
                ImageView mininavdisplay = new ImageView(mininav) ;
                mininavdisplay.setFitWidth(600);
                mininavdisplay.setFitHeight(60);
                Label topiclabel = new Label("add item") ;
                Label txtlabel1 = new Label("Name: ") ;
                Label txtlabel2 = new Label("Price: ") ;
                TextField productname = new TextField() ;
                TextField productprice = new TextField() ;
                productname.setPromptText("Name");
                productprice.setPromptText("Price");
                Button confirmbutton = new Button("Confirm") ;
                ImageView loveshow = new ImageView(loveicon) ;
                loveshow.setFitWidth(200);
                loveshow.setFitHeight(200);





                StackPane additemstackpane = new StackPane() ;
                additemstackpane.getChildren().addAll(minibackgrounddisplay , mininavdisplay , exitbuttonmini , minimizebuttonmini , topiclabel , productname , productprice , txtlabel1 , txtlabel2 , confirmbutton , loveshow) ;




                minibackgrounddisplay.getStyleClass().add("minibackgrounddisplay") ;
                mininavdisplay.getStyleClass().add("mininavdisplay") ;
                exitbuttonmini.getStyleClass().add("exitbuttonmini") ;
                minimizebuttonmini.getStyleClass().add("minimizebuttonmini") ;
                topiclabel.getStyleClass().add("topiclabel") ;
                productname.getStyleClass().add("productname") ;
                productprice.getStyleClass().add("productprice") ;
                txtlabel1.getStyleClass().add("txtlabel1") ;
                txtlabel2.getStyleClass().add("txtlabel2") ;
                confirmbutton.getStyleClass().add("confirmbutton") ;
                loveshow.getStyleClass().add("loveshow") ;





                Scene additemscene = new Scene(additemstackpane , 600 , 600) ;
                additemscene.getStylesheets().add(getClass().getResource("FactorScene.css").toExternalForm()) ;


                Stage additemstage = new Stage() ;
                additemstage.setScene(additemscene);
                additemstage.setTitle("New Item");
                additemstage.initStyle(StageStyle.UNDECORATED);
                additemstage.show();






                // ADD ITEM EVENT HANDELERS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!**************************************************








                confirmbutton.setOnAction(e -> {


                    additemname = productname.getText().toString() ;
                    additemprice = dollarsign + productprice.getText().toString() ;






                    additemstage.close();


                });





















                // EXIT &&& MINIMIZE BUTTONS HANDELER !!!!!!!!!!!



                exitbuttonmini.setOnAction(e -> { additemstage.close(); });
                minimizebuttonmini.setOnAction(e -> additemstage.setIconified(true));








                // MAKES DRAGGING BRO !!!!!!!!!!!



                additemstackpane.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        xOffset = additemstage.getX() - event.getScreenX();
                        yOffset = additemstage.getY() - event.getScreenY();
                    }
                });

                additemstackpane.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        additemstage.setX(event.getScreenX() + xOffset);
                        additemstage.setY(event.getScreenY() + yOffset);
                    }
                });




            }
        });








        // SCENES FOR FACTOR MAKING AND STUFFS!!!!!@@@@@@@@@@@@@@@@@!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@############################################
        // MINI TWO
        //MINI TWO



        general2.setOnMousePressed(new EventHandler<MouseEvent>() {

            private double xOffset = 0;
            private double yOffset = 0;

            @Override
            public void handle(MouseEvent event) {





                Image minibackground = new Image("com//cloudly//aestudios//Files//Background//minisbackground.png") ;
                Image mininav = new Image("com//cloudly//aestudios//Files//Background//ministopnavigation.png") ;
                ImageView backgroundshow = new ImageView(minibackground) ;
                ImageView navbarshow = new ImageView(mininav) ;
                backgroundshow.setFitWidth(600);
                backgroundshow.setFitHeight(600);
                navbarshow.setFitWidth(600);
                navbarshow.setFitHeight(60);
                Image exticon = new Image("com//cloudly//aestudios//Files//Background//exiticonminis.png") ;
                Image mnimzeicon = new Image("com//cloudly//aestudios//Files//Background//minisminimizeicon.png") ;
                Button exitbutton = new Button() ;
                Button minimizebutton = new Button() ;
                exitbutton.setGraphic(new ImageView(exticon));
                minimizebutton.setGraphic(new ImageView(mnimzeicon));
                Label topiclabel = new Label("Make Factor") ;
                TextField searchbar = new TextField() ;
                searchbar.setPromptText("Search");
                Button printbutton = new Button() ;
                Button confirmbutton2 = new Button("Confirm") ;
                Image printericon = new Image("com//cloudly//aestudios//Files//Background//printer.png") ;
                printbutton.setGraphic(new ImageView(printericon));


























                StackPane makefactorstackpane = new StackPane() ;
                makefactorstackpane.getChildren().addAll(backgroundshow , navbarshow , exitbutton , minimizebutton , topiclabel , searchbar , cartitems , printbutton , confirmbutton2) ;




                backgroundshow.getStyleClass().add("minibackgrounddisplay") ;
                navbarshow.getStyleClass().add("mininavdisplay") ;
                exitbutton.getStyleClass().add("exitbuttonmini") ;
                minimizebutton.getStyleClass().add("minimizebuttonmini") ;
                topiclabel.getStyleClass().add("topiclabel2") ;
                searchbar.getStyleClass().add("searchbar") ;
                confirmbutton2.getStyleClass().add("confirmbutton2") ;
                searchresults.getStyleClass().add("searchresults") ;
                cartitems.getStyleClass().add("cartitems") ;
                printbutton.getStyleClass().add("printbutton") ;



                Scene makefactorscene = new Scene(makefactorstackpane , 600 , 600) ;
                makefactorscene.getStylesheets().add(getClass().getResource("FactorScene.css").toExternalForm()) ;


                Stage makefactorstage = new Stage() ;
                makefactorstage.setScene(makefactorscene);
                makefactorstage.initStyle(StageStyle.UNDECORATED);
                makefactorstage.setTitle("Make Factor");
                makefactorstage.show();













                // SEARCHBAR DESIGN

                searchbar.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {


                        searchbar.setStyle("-fx-background-radius: 0px 0px 0px 0px") ;
                        makefactorstackpane.getChildren().add(searchresults) ;


                    }
                });

                backgroundshow.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {


                        makefactorstackpane.getChildren().remove(searchresults);
                        searchbar.setStyle("-fx-background-radius: 5px 5px 5px 5px") ;


                    }
                });







                // EXIT &&& MINIMIZE BUTTONS HANDELER !!!!!!!!!!!



                exitbutton.setOnAction(e -> { makefactorstage.close(); });
                minimizebutton.setOnAction(e -> makefactorstage.setIconified(true));










                // MAKES DRAGGING BRO !!!!!!!!!!!



                makefactorstackpane.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        xOffset = makefactorstage.getX() - event.getScreenX();
                        yOffset = makefactorstage.getY() - event.getScreenY();
                    }
                });

                makefactorstackpane.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        makefactorstage.setX(event.getScreenX() + xOffset);
                        makefactorstage.setY(event.getScreenY() + yOffset);
                    }
                });






            }
        });





        // SCENES FOR FACTOR MAKING AND STUFFS!!!!!@@@@@@@@@@@@@@@@@!!!!!!!!!!!!!!!!!!!!!@@@@@@@@@@@@@@@@@@@############################################
        // MINI THREE
        //MINI THREE





        general3.setOnMousePressed(new EventHandler<MouseEvent>() {

            private double xOffset = 0 ;
            private double yOffset = 0 ;
            String fname , lname , phone , adress ;

            @Override
            public void handle(MouseEvent event) {




                Image minibackground = new Image("com//cloudly//aestudios//Files//Background//minisbackground.png") ;
                Image mininav = new Image("com//cloudly//aestudios//Files//Background//ministopnavigation.png") ;
                ImageView backgroundshow = new ImageView(minibackground) ;
                ImageView navbarshow = new ImageView(mininav) ;
                backgroundshow.setFitWidth(800);
                backgroundshow.setFitHeight(600);
                navbarshow.setFitWidth(800);
                navbarshow.setFitHeight(60);
                Image exticon = new Image("com//cloudly//aestudios//Files//Background//exiticonminis.png") ;
                Image mnimzeicon = new Image("com//cloudly//aestudios//Files//Background//minisminimizeicon.png") ;
                Button exitbutton = new Button() ;
                Button minimizebutton = new Button() ;
                exitbutton.setGraphic(new ImageView(exticon));
                minimizebutton.setGraphic(new ImageView(mnimzeicon));
                Label topiclabel = new Label("Clients Form") ;
                Label infolabel = new Label("New Customer") ;
                Label deslabel1 = new Label("FirstName:") ;
                Label deslabel2 = new Label("LastName:") ;
                Label deslabel3 = new Label("Phone:") ;
                Label deslabel4 = new Label("Adress:") ;
                TextField customerfname = new TextField() ;
                TextField customerlname = new TextField() ;
                TextField customerphone = new TextField() ;
                TextField customeradress = new TextField() ;
                Button donebutton = new Button("Confirm") ;
                customerfname.setPromptText("FirstName");
                customerlname.setPromptText("LastName");
                customerphone.setPromptText("Phone");
                customeradress.setPromptText("Adress");







                StackPane ministackpane = new StackPane() ;
                ministackpane.getChildren().addAll(backgroundshow , navbarshow , exitbutton , minimizebutton , topiclabel , infolabel , customerfname , customerlname , customerphone , customeradress , donebutton , deslabel1 , deslabel2 , deslabel3 , deslabel4 , customertable) ;



                backgroundshow.getStyleClass().add("minibackgrounddisplay2") ;
                navbarshow.getStyleClass().add("mininavdisplay2") ;
                exitbutton.getStyleClass().add("exitbuttonmini2") ;
                minimizebutton.getStyleClass().add("minimizebuttonmini2") ;
                topiclabel.getStyleClass().add("topiclabel2") ;
                infolabel.getStyleClass().add("infolabel") ;
                customerfname.getStyleClass().add("customerfname") ;
                customerlname.getStyleClass().add("customerlname") ;
                customerphone.getStyleClass().add("customerphone") ;
                customeradress.getStyleClass().add("customeradress") ;
                donebutton.getStyleClass().add("donebutton") ;
                deslabel1.getStyleClass().add("deslabel1") ;
                deslabel2.getStyleClass().add("deslabel2") ;
                deslabel3.getStyleClass().add("deslabel3") ;
                deslabel4.getStyleClass().add("deslabel4") ;
                customertable.getStyleClass().add("customertable") ;




                Scene myscene = new Scene(ministackpane , 800 , 600) ;
                myscene.getStylesheets().add(getClass().getResource("FactorScene.css").toExternalForm()) ;


                Stage ministage = new Stage() ;
                ministage.setScene(myscene);
                ministage.initStyle(StageStyle.UNDECORATED);
                ministage.setTitle("Customers");
                ministage.show();









                // EVENT  HANDELERS HEREEEEEEEEEEEEEEEEEE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11




                donebutton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {



                        fname = customerfname.getText().toString() ;
                        lname = customerlname.getText().toString() ;
                        phone = customerphone.getText().toString() ;
                        adress = customeradress.getText().toString() ;




                        customertable.getItems().add(new CustomerTable(fname , lname , phone , adress)) ;



                        customerfname.setText(null);
                        customerlname.setText(null);
                        customerphone.setText(null);
                        customeradress.setText(null);


                    }
                });





                // EXIT &&& MINIMIZE BUTTONS HANDELER !!!!!!!!!!!



                exitbutton.setOnAction(e -> { ministage.close(); });
                minimizebutton.setOnAction(e -> ministage.setIconified(true));










                // MAKES DRAGGING BRO !!!!!!!!!!!



                ministackpane.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        xOffset = ministage.getX() - event.getScreenX();
                        yOffset = ministage.getY() - event.getScreenY();
                    }
                });

                ministackpane.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        ministage.setX(event.getScreenX() + xOffset);
                        ministage.setY(event.getScreenY() + yOffset);
                    }
                });







            }
        });








    }



}