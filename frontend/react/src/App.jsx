import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import SidebarWithHeader from './shared/slideBAR.jsx'
import { Button, ButtonGroup } from '@chakra-ui/react'

function App() {


  return ( <SidebarWithHeader>
                <Button colorScheme='blue'>Button</Button>
              </SidebarWithHeader>)
}

export default App
