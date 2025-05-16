/********************************************************************************
** Form generated from reading UI file 'mainwindow.ui'
**
** Created by: Qt User Interface Compiler version 6.9.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWINDOW_H
#define UI_MAINWINDOW_H

#include <QtCore/QVariant>
#include <QtGui/QIcon>
#include <QtWidgets/QApplication>
#include <QtWidgets/QGroupBox>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralwidget;
    QLineEdit *lineEdit_2;
    QGroupBox *groupBox;
    QPushButton *pushButton_3;
    QPushButton *pushButton;
    QPushButton *pushButton_2;
    QGroupBox *groupBox_2;
    QLineEdit *lineEdit;
    QPushButton *pushButton_4;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName("MainWindow");
        MainWindow->resize(800, 600);
        centralwidget = new QWidget(MainWindow);
        centralwidget->setObjectName("centralwidget");
        centralwidget->setStyleSheet(QString::fromUtf8(" width: 360;\n"
" height: 640;\n"
" background-color: \"white\";  \n"
""));
        lineEdit_2 = new QLineEdit(centralwidget);
        lineEdit_2->setObjectName("lineEdit_2");
        lineEdit_2->setGeometry(QRect(40, 30, 241, 41));
        QFont font;
        font.setBold(true);
        lineEdit_2->setFont(font);
        lineEdit_2->setStyleSheet(QString::fromUtf8("border: none;\n"
"color: black;\n"
"font-size: 34px;\n"
"background-color: \"transparent\";\n"
"style: \"bold\";"));
        lineEdit_2->setReadOnly(true);
        groupBox = new QGroupBox(centralwidget);
        groupBox->setObjectName("groupBox");
        groupBox->setGeometry(QRect(290, 10, 211, 80));
        groupBox->setStyleSheet(QString::fromUtf8("background-color: \"transparent\";\n"
"border: none;"));
        pushButton_3 = new QPushButton(groupBox);
        pushButton_3->setObjectName("pushButton_3");
        pushButton_3->setGeometry(QRect(10, 20, 41, 41));
        pushButton_3->setCursor(QCursor(Qt::CursorShape::PointingHandCursor));
        pushButton_3->setStyleSheet(QString::fromUtf8("background-color: \"transparent\";\n"
"border: none;"));
        QIcon icon;
        icon.addFile(QString::fromUtf8("D:/Ali/icons/status (2).png"), QSize(), QIcon::Mode::Normal, QIcon::State::Off);
        pushButton_3->setIcon(icon);
        pushButton_3->setIconSize(QSize(25, 25));
        pushButton = new QPushButton(groupBox);
        pushButton->setObjectName("pushButton");
        pushButton->setGeometry(QRect(60, 20, 51, 41));
        pushButton->setStyleSheet(QString::fromUtf8("background-color: \"transparent\";\n"
"border: none;"));
        QIcon icon1;
        icon1.addFile(QString::fromUtf8("D:/Ali/icons/message.png"), QSize(), QIcon::Mode::Normal, QIcon::State::Off);
        pushButton->setIcon(icon1);
        pushButton->setIconSize(QSize(25, 25));
        pushButton_2 = new QPushButton(groupBox);
        pushButton_2->setObjectName("pushButton_2");
        pushButton_2->setGeometry(QRect(110, 20, 51, 41));
        pushButton_2->setStyleSheet(QString::fromUtf8("background-color: \"transparent\";\n"
"border: none;"));
        QIcon icon2;
        icon2.addFile(QString::fromUtf8("D:/Ali/icons/more.png"), QSize(), QIcon::Mode::Normal, QIcon::State::Off);
        pushButton_2->setIcon(icon2);
        pushButton_2->setIconSize(QSize(25, 25));
        groupBox_2 = new QGroupBox(centralwidget);
        groupBox_2->setObjectName("groupBox_2");
        groupBox_2->setGeometry(QRect(10, 50, 551, 151));
        groupBox_2->setStyleSheet(QString::fromUtf8("background-color: \"transparent\";\n"
"border: none;"));
        lineEdit = new QLineEdit(groupBox_2);
        lineEdit->setObjectName("lineEdit");
        lineEdit->setGeometry(QRect(0, 60, 441, 61));
        lineEdit->setStyleSheet(QString::fromUtf8("  qproperty-frame: false;\n"
"placeholderText: \"Pesquisar conversas..\";\n"
"border: 1px solid #CCC;           /* \342\206\220 defines the outline you\342\200\231ll round */\n"
"border-radius: 30px;\n"
"color: \"white\"; \n"
"border.color: \"#D0D0D0\"; \n"
"background-color: #E1ECE1;\n"
"font-size: 20px;\n"
"padding-left: 20px;\n"
"color: \"black\";"));
        pushButton_4 = new QPushButton(groupBox_2);
        pushButton_4->setObjectName("pushButton_4");
        pushButton_4->setGeometry(QRect(380, 60, 61, 61));
        pushButton_4->setStyleSheet(QString::fromUtf8("background-color: #D3E8D2;\n"
"border: none;\n"
"border-radius: 30px;"));
        QIcon icon3;
        icon3.addFile(QString::fromUtf8("D:/Ali/icons/search (1).png"), QSize(), QIcon::Mode::Normal, QIcon::State::Off);
        pushButton_4->setIcon(icon3);
        pushButton_4->setIconSize(QSize(20, 20));
        MainWindow->setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar->setObjectName("menubar");
        menubar->setGeometry(QRect(0, 0, 800, 26));
        MainWindow->setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar->setObjectName("statusbar");
        MainWindow->setStatusBar(statusbar);

        retranslateUi(MainWindow);

        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QCoreApplication::translate("MainWindow", "MainWindow", nullptr));
        lineEdit_2->setText(QCoreApplication::translate("MainWindow", "WhatsApp", nullptr));
        groupBox->setTitle(QString());
        pushButton_3->setText(QString());
        pushButton->setText(QString());
        pushButton_2->setText(QString());
        groupBox_2->setTitle(QString());
        pushButton_4->setText(QString());
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
