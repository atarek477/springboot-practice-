import { Button, ButtonGroup ,Spinner,Text,Wrap,WrapItem} from '@chakra-ui/react'
import React from 'react';
import {
  Drawer,
  DrawerOverlay,
  DrawerContent,
  DrawerCloseButton,
  DrawerHeader,
  DrawerBody,
  DrawerFooter,
  Input,
} from '@chakra-ui/react';
import { useDisclosure } from '@chakra-ui/react';
import CreateCustomerForm from './CreateCustomerForm';
import UpdateForm from './UpdateForm';



const UpdateDrawer= ({id,name,email,age,gender})=>{

    const { isOpen, onOpen, onClose } = useDisclosure()
    return(
<>
<Button colorScheme={'green'} onClick={onOpen}>Update customer</Button>
<Drawer isOpen={isOpen} onClose={onClose} size={'xl'}>
          <DrawerOverlay />
          <DrawerContent>
            <DrawerCloseButton />
            <DrawerHeader>Update customer</DrawerHeader>
  
            <DrawerBody>
             <UpdateForm 
             id ={id}
             name={name}
             email={email}
             age ={age}
             gender={gender}/>
              
            </DrawerBody>
  
            <DrawerFooter>
            <Button colorScheme={'red'} onClick={onClose}>Close</Button>
            </DrawerFooter>
          </DrawerContent>
        </Drawer>
</>
    )




}
export default UpdateDrawer;