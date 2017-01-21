#include <SPI.h>
#include <Pixy.h>

Pixy pixy;
uint16_t blocks;
int areaCount = 10;
double area[10];
double avgArea;
int i = 0;

//******ANGLE VARIABLES******
double angleToTarget_x; //horizontal angle in degrees
double angleToTarget_y; //vertical angle in degrees
double FOV_X = 75; //horizontal Field of View in degrees
double FOV_Y = 47; //vertical Field of View in degrees
double RESOLUTION_WIDTH = 320; //in pixels, 320 x 200
double RESOLUTION_HEIGHT = 200; //in pixels
double VERTICAL_ZERO_OFFSET = 23.5; //shifts the 0 degree line down by given value, relies on consistent angle of camera
double CAMERA_ANGLE = 12; //angle of Camera

//******DISTANCE VARIABLES******
double distanceToTarget; //inches
double CAMERA_HEIGHT = 2.25; //inches
double TARGET_HEIGHT = 3; //inches
double areaOfTarget;

void setup() {
  Serial.begin(9600);
  Serial.print("Starting...\n");

  pixy.init();

  for(int i = 0; i < areaCount; i++) {
    area[i] = getArea();
  }
}

void loop() { 
  char buf[32]; 
  blocks = pixy.getBlocks();

  if (blocks) {
    // get/print data every 50 frames

    getAvgArea();
    i++;
    if (i % 30 == 0) {
      for(int i = 1; i < areaCount; i++) {
        area[i - 1] = area[i];
      }

      area[9] = getArea();

      avgArea = getAvgArea();  
      angleToTarget_x = getHorizontalAngleOffset(pixy.blocks[0].x);
      angleToTarget_y = getVerticalAngleOffset(pixy.blocks[0].y);
      distanceToTarget = getDistance(); 

      Serial.print("DISTANCE(IN.): ");
      Serial.print(distanceToTarget);
      Serial.print(" ANGLE: " );
      Serial.print(angleToTarget_y);
      Serial.print(" AREA: ");
      Serial.print(avgArea);
      Serial.print(" Width: ");
      Serial.print(pixy.blocks[0].width);
      Serial.print(" Height: ");
      Serial.println(pixy.blocks[0].height);
      Serial.print(" RAW AREA: ");
      Serial.println(pixy.blocks[0].height * pixy.blocks[0].width);
        
    }
  }  
}

//******THE IMPORTANT STUFF******

double getHorizontalAngleOffset(double x){
  return (x*FOV_X/RESOLUTION_WIDTH) - 37.5;
}

double getVerticalAngleOffset(double y) {
  return (VERTICAL_ZERO_OFFSET - (y*FOV_Y/RESOLUTION_HEIGHT )) + CAMERA_ANGLE; //
}

double degreesToRadians(double deg){
  return (deg * 3.1415926)/180;
}

double getArea() {
  return pixy.blocks[0].height * pixy.blocks[0].width;
}

double getAvgArea() {
  double total;
  for(int i = 0; i < areaCount; i++) {
    total = total + area[i];
  }

  return total / areaCount;
}

double getDistance(){
  
  return (TARGET_HEIGHT-CAMERA_HEIGHT)/tan(degreesToRadians((angleToTarget_y)));
}


