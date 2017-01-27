import cv2
import numpy
import math

img = cv2.imread("GripPhoto.jpg", cv2.CV_LOAD_IMAGE_COLOR);
cv2.namedWindow("Display Window", cv2.CV_WINDOW_AUTOSIZE);
img = cv2.resize(img, (0,0), fx=0.2, fy=0.2);

ret,thresh1 = cv2.threshold(img,220,255,cv2.THRESH_BINARY);
ret,thresh2 = cv2.threshold(img,220,255,cv2.THRESH_TOZERO);


cv2.imshow("Display Window", thresh2);
cv2.waitKey(0);
cv2.destroyWindow("Display Window");

