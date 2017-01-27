import cv2
import numpy
import math
import numpy as np

img = cv2.imread("GripPhoto.jpg", cv2.CV_LOAD_IMAGE_COLOR);
cv2.namedWindow("Display Window", cv2.CV_WINDOW_AUTOSIZE);
img = cv2.resize(img, (0,0), fx=0.2, fy=0.2);
img = img[100:501, 100:600];
ret,thresh1 = cv2.threshold(img,220,255,cv2.THRESH_BINARY,img);
#imgray = cv2.cvtColor(img,cv2.COLOR_BGR2HSV);
ret,thresh2 = cv2.threshold(img,132,255,cv2.THRESH_TOZERO);

lowerGreen = np.array([0,100,0]);
upperGreen = np.array([144,255,100]);

thresh2 = cv2.inRange(thresh2,lowerGreen, upperGreen);

#cv2.findContours(thresh2,cv2.RETR_TREE,cv2.CHAIN_APPROX_NONE)
#cv2.drawContours(thresh2, contours, 1, (0,255,0), 50)


cv2.imshow("Display Window", thresh2);
cv2.waitKey(0);
cv2.destroyWindow("Display Window");

