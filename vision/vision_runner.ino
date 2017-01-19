#include <SPI.h>
#include <Pixy.h>

// This is the main Pixy object 
Pixy pixy;

//******ANGLE VARIABLES******
double angleToTarget_x; //horizontal angle in degrees
double angleToTarget_y; //vertical angle in degrees
double FOV_X = 75; //horizontal Field of View in degrees
double FOV_Y = 47; //vertical Field of View in degrees
double RESOLUTION_WIDTH = 320; //in pixels, 320 x 200
double RESOLUTION_HEIGHT = 200; //in pixels
double VERTICAL_ZERO_OFFSET = 23.5; //shifts the 0 degree line down by given value, relies on consistent angle of camera

//******DISTANCE VARIABLES******
double distanceToTarget; //inches
double CAMERA_HEIGHT = 2.25; //inches
double TARGET_HEIGHT = 13; //inches 



void setup()
{
  Serial.begin(9600);
  Serial.print("Starting...\n");

  pixy.init();
}

void loop()
{ 
  static int i = 0;
  int j;
  uint16_t blocks;
  char buf[32]; 
  
  // grab blocks!
  blocks = pixy.getBlocks();
  
  
  // If there are detect blocks, print them!
  if (blocks)
  {
    i++;
    
    /* do this (print) every 50 frames because printing every
       frame would bog down the Arduino
    */
    
    if (i%50==0)
    {
        angleToTarget_x = getHorizontalAngleOffset(pixy.blocks[0].x);
        angleToTarget_y = getVerticalAngleOffset(pixy.blocks[0].y);
        distanceToTarget = getDistance();
        
        Serial.print(distanceToTarget);
        Serial.print(" ANGLE " );
        Serial.println(angleToTarget_y);
    }

  
  }  
}

//******THE IMPORTANT STUFF******

double getHorizontalAngleOffset(double x){
  return (x*FOV_X/RESOLUTION_WIDTH) - 37.5;
}

double getVerticalAngleOffset(double y) {
  return VERTICAL_ZERO_OFFSET-(y*FOV_Y/RESOLUTION_HEIGHT ); //
}

double degreesToRadians(double deg){
  return (deg * 3.1415926)/180;
}

double getDistance(){
  return (TARGET_HEIGHT-CAMERA_HEIGHT)/tan(degreesToRadians((angleToTarget_y)));
}


