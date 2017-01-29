import cv2
import numpy
import math
import numpy as np

resWidth = 0
resHeight = 0

#Grab and return an image after flipping and resizing it
def getImage():
    img = cv2.imread("4ft.jpg", cv2.CV_LOAD_IMAGE_COLOR)
    img = cv2.resize(img, (0,0), fx=0.2, fy=0.2)
    img = cv2.flip(img, -1)

    return img

#Return an image with everything but green filtered out
def threshhold(img):
    ret, thresh = cv2.threshold(img,200,255,cv2.THRESH_TOZERO)
    ret, thresh2 = cv2.threshold(thresh,240,255,cv2.THRESH_BINARY,img)

    lowerGreen = np.array([0,50,0])
    upperGreen = np.array([255,255,100])

    thresh2 = cv2.inRange(thresh2,lowerGreen, upperGreen)
    return thresh2

#Find and return the contours of an image
def contourImage(img):
    contours, ret = cv2.findContours(img,cv2.RETR_TREE,cv2.CHAIN_APPROX_SIMPLE)
    return contours

#Compare the areas of all the contours and return the largest one along with it's index
def getLargestContour(contours):
    largest = contours[0]
    index = 0
    greatestArea = 0
    for i in range(len(contours)):
        if cv2.contourArea(contours[i]) > greatestArea:
            largest = contours[i]
            index = i
            greatestArea = cv2.contourArea(contours[i])
    return index, greatestArea

#Get distance to target based off of the area of the greatest contour
def getDistanceArea(area):
    return 17.0348*math.exp(-.0004543*area)

img = getImage()
thresh = threshhold(img)

contours = contourImage(thresh)
largestContourIndex, contourArea = getLargestContour(contours)
cv2.drawContours(img, contours, largestContourIndex, (255,0,0), 3)

print(getDistanceArea(contourArea))

cv2.namedWindow("Display Window", cv2.CV_WINDOW_AUTOSIZE)
cv2.imshow("Display Window", img)
cv2.waitKey(0)
cv2.destroyWindow("Display Window")
