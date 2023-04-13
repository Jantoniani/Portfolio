import { Heading, HStack, Image, Text, VStack } from "@chakra-ui/react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faArrowRight } from "@fortawesome/free-solid-svg-icons";
import React from "react";


const Card = ({ title, description, imageSrc }) => {


  // Implement the UI for the Card component according to the instructions.
  // You should be able to implement the component with the elements imported above.
  // Feel free to import other UI components from Chakra UI if you wish
  return (    
    <VStack align='left' bg='white' pb={3} rounded="lg">
      <Image src={imageSrc} rounded="lg" />
      <Heading color='black' size='md' pl={4} pt={4}>{title}</Heading>
      <Text color='gray' pl={4} pr={6}>{description}</Text>
      <HStack pl={4}>
          <Text color='black' fontSize="sm">See more</Text>
          <FontAwesomeIcon icon={faArrowRight} size="1x" color='black' />
      </HStack>
    </VStack>
  );
};

export default Card;
