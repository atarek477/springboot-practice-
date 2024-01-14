import { useState } from 'react'
import { useEffect } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import SidebarWithHeader from './shared/slideBAR.jsx'
import { Button, ButtonGroup } from '@chakra-ui/react'
import { getCustomer } from './services/client.js'
function App() {
useEffect(()=>{
getCustomer().then(res=>{console.log(res)}).catch(e=>{console.log(e)})


},[])

  return ( <SidebarWithHeader>
                <Button colorScheme='blue'>Button</Button>
              </SidebarWithHeader>)
}

export default App
