#include "chatcard.h"
#include "ui_chatcard.h"
#include "./utilities.h"
#include <QLayout>

chatcard::chatcard(QWidget *parent, QString Profile)
    : QWidget(parent)
    , ui(new Ui::chatcard)
{
    ui->setupUi(this);
    // zero out internals
    if (auto *lyt = this->layout()) {
        lyt->setContentsMargins(10,10,10,10);
        lyt->setSpacing(2);
    }
    setRoundImage(ui->ProfilePic, Profile);
}

void chatcard::setProfilePic(QString Pic) {
    setRoundImage(ui->ProfilePic, Pic);
}
void chatcard::setTime(QString t) {
    ui->time->setText(t);
}
void chatcard::setName(QString n) {
    ui->name->setText(n);
}
void chatcard::setMessage(QString m) {
    ui->message->setText(m);
}


chatcard::~chatcard()
{
    delete ui;
}
