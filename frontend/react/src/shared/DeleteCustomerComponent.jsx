import { Button, AlertDialog, AlertDialogOverlay, AlertDialogContent, AlertDialogHeader, AlertDialogBody, AlertDialogFooter, useDisclosure } from '@chakra-ui/react';
import { deleteCustomer,getCustomer } from '../services/client'
import React, { useRef } from 'react';
import { useState } from 'react'
function DeleteCustomerComponent({id}) {
  const [loading, setLoading]= useState(false)
  const [customers, setCustomers]= useState([])
  const fetchCustomer=()=>{
    setLoading(true)
 
   getCustomer().then(res=>{setCustomers(res.data)}).catch(e=>{console.log(e)}).finally(setLoading(false))}
  
    const { isOpen, onOpen, onClose } = useDisclosure()
    const cancelRef= useRef()
    return (
      <>
        <Button colorScheme='red' onClick={onOpen}>
          Delete Customer
        </Button><object data="" type=""></object>
  
        <AlertDialog
          isOpen={isOpen}
          leastDestructiveRef={cancelRef}
          onClose={onClose}
        >
          <AlertDialogOverlay>
            <AlertDialogContent>
              <AlertDialogHeader fontSize='lg' fontWeight='bold'>
                Delete Customer
              </AlertDialogHeader>
  
              <AlertDialogBody>
                Are you sure? You can't undo this action afterwards.
              </AlertDialogBody>
  
              <AlertDialogFooter>
                <Button ref={cancelRef} onClick={onClose}>
                  Cancel
                </Button>
                <Button colorScheme='red' onClick={() => {deleteCustomer(id);onClose();window.location.reload();}} ml={3}>
                  Delete
                </Button>
              </AlertDialogFooter>
            </AlertDialogContent>
          </AlertDialogOverlay>
        </AlertDialog>
      </>
    )
  }
  export default DeleteCustomerComponent