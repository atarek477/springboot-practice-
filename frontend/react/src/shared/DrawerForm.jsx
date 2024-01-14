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

const Appicon=()=>{return "+"}
const Closeicon=()=>{return "x"}

const DrawerForm= ({fetchCustomer})=>{

    const { isOpen, onOpen, onClose } = useDisclosure()
    return(
<>
<Button leftIcon={<Appicon/>} colorScheme={'blue'} onClick={onOpen}>create customer</Button>
<Drawer isOpen={isOpen} onClose={onClose} size={'xl'}>
          <DrawerOverlay />
          <DrawerContent>
            <DrawerCloseButton />
            <DrawerHeader>Create New Customer</DrawerHeader>
  
            <DrawerBody>
             <CreateCustomerForm 
             fetchCustomer= {fetchCustomer}/>
              
            </DrawerBody>
  
            <DrawerFooter>
            <Button leftIcon={<Closeicon/>} colorScheme={'red'} onClick={onClose}>Close</Button>
            </DrawerFooter>
          </DrawerContent>
        </Drawer>
</>
    )




}
export default DrawerForm;


