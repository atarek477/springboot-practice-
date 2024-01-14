import { useState } from 'react'
import { useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import SidebarWithHeader from './shared/slideBAR.jsx'
import CardWithImage from './shared/card.jsx'
import DrawerForm from './shared/DrawerForm.jsx'

import { Button, ButtonGroup ,Spinner,Text,Wrap,WrapItem} from '@chakra-ui/react'
import { getCustomer } from './services/client.js'

function App() {

  const [customers, setCustomers]= useState([])
  const [loading, setLoading]= useState(false)
const fetchCustomer=()=>{
   setLoading(true)

  getCustomer().then(res=>{setCustomers(res.data)}).catch(e=>{console.log(e)}).finally(setLoading(false))}

useEffect(()=>{
 fetchCustomer();


},[])
if(loading){
return( <SidebarWithHeader>
  <DrawerForm/>
  <Spinner
  thickness='4px'
  speed='0.65s'
  emptyColor='gray.200'
  color='blue.500'
  size='xl'
/><Button colorScheme='blue'>Button</Button>
</SidebarWithHeader>)



}
if(customers.length<=0){

return(<SidebarWithHeader>
  <DrawerForm 
    fetchCustomer = {fetchCustomer}
    />
  <Text>no customer exist</Text>
</SidebarWithHeader>)

}
//<p key={index}>{customer.name}</p>
  return ( <SidebarWithHeader>
    <DrawerForm 
    fetchCustomer = {fetchCustomer}
    />
              <Wrap justify={"center"} spacing={"20px"}>
             {customers.map((customer,index)=>(<WrapItem key={index}><CardWithImage {...customer}
             ImageNumber={index} /></WrapItem>))}
             </Wrap>
              </SidebarWithHeader>)
}

export default App
