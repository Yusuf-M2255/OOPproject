#include "mainwindow.h"
#include "./ui_mainwindow.h"
#include "chatcard.h"

#include <QVBoxLayout>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    /*
    ui->CardContainer->layout()->setSpacing(0);       // Vertical gap between cards
    ui->CardContainer->layout()->setContentsMargins(0, 0, 0, 0);
    ui->CardContainer->setAlignment(Qt::AlignTop);

    for (int i = 0; i < 20; ++i) {
        ui->CardContainer->addWidget(new chatcard(this));
        //ui->CardContainer->addWidget(new chatcard(this));
    }*/

    QWidget *container = new QWidget();
    QVBoxLayout *ChatCardLayout = new QVBoxLayout(container);
    ChatCardLayout->setSpacing(1);
    ChatCardLayout->setContentsMargins(0, 0, 0, 0);

    for (int i = 0; i < 20; ++i) {
        chatcard* card = new chatcard(this);
        card->setProfilePic(":/images/random.jpg");
        card->setName("Ali Abdelhady");
        card->setMessage("Some long message");
        card->setTime("09:16");
        ChatCardLayout->addWidget(card);
    }

    ChatCardLayout->addStretch();
    container->setLayout(ChatCardLayout);
    ui->scrollArea->setWidget(container);
    ui->scrollArea->setWidgetResizable(true);
    //ui->scrollArea->adjustSize();
    //ui->scrollArea->setWidgetResizable(true);
    //ui->scrollArea->setSizePolicy(QSizePolicy::Expanding,
      //                        QSizePolicy::Expanding);
    container->adjustSize();
    container->setSizePolicy(QSizePolicy::Expanding, QSizePolicy::Maximum);
}

MainWindow::~MainWindow()
{
    delete ui;
}
