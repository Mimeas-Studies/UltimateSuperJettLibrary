import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <img src={reactLogo} alt="react logo" className='logo'/>
      <h1>Ultimate Super Ultra Jetty Server</h1>
      <hr/>
    </div>
  )
}

export default App
