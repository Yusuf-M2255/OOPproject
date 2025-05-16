#include "./utilities.h"
#include <QPainterPath>

void setRoundImage(QLabel* label, const QString& imagePath) {
    // Get desired size from label or use default
    QSize targetSize = label->size().isEmpty() ? QSize(100, 100) : label->size();

    // Ensure square for perfect circle
    int size = qMin(targetSize.width(), targetSize.height());
    targetSize = QSize(size, size);

    // Load and scale image
    QPixmap pixmap(imagePath);
    if(pixmap.isNull()) return;

    pixmap = pixmap.scaled(targetSize,
                           Qt::KeepAspectRatioByExpanding,
                           Qt::SmoothTransformation);

    // Create rounded pixmap
    QPixmap rounded(targetSize);
    rounded.fill(Qt::transparent);

    QPainter painter(&rounded);
    painter.setRenderHints(QPainter::Antialiasing | QPainter::SmoothPixmapTransform);
    QPainterPath path;
    path.addEllipse(rounded.rect());
    painter.setClipPath(path);
    painter.drawPixmap(0, 0, pixmap);

    label->setPixmap(rounded);
    label->setFixedSize(targetSize);  // Ensure square aspect ratio
}
