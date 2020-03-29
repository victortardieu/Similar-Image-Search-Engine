# Similar Image Search Engine

## Description
The program is required to hash an input image into a fixed-length bit string (called hash code), before storing the resulting bit string (as the key of a pointer to the original image) in an appropriately constructed and maintained search tree. Any number of images will be stored that way. Hence, a cue image can be used as input, together with a user-specified tolerance (specified as a percentage). Your program should then return all stored images whose hash codes are within tolerance of the cue image, doing so in c.log(n) time complexity, on average, where n is the current number of images stored in the tree and c is a constant value. The special challenge is in finding and using a hash function that provides hash codes better representative of the content of the hashed image than method 1 (or even all the methods) in the “BlockHashing” paper.

## Course & University
COEN 352 - Data Structures and Algorithms  
Concordia University, Montreal

## Author
Victor Tardieu
